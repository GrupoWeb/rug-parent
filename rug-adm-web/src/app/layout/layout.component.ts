import { Component, OnInit, EventEmitter } from '@angular/core';
import { UsersService } from '../shared/users.service';
import { Router } from '@angular/router';
import { User } from '../shared/user.model';
import { Subscription } from 'rxjs/Subscription';
import { LoadingService } from '../shared/loading.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {
  public loading = false;
  public user: User;
  sidenavActions = new EventEmitter<any>();
  sidenavParams = [{edge:'left', closeOnClick:true}];
  loadingSubscription: Subscription;

  constructor(private usersService: UsersService,
    private loadingService: LoadingService,
    private router: Router) { }

  ngOnInit() {
    this.user = this.usersService.authenticatedUser;

    this.loadingSubscription = this.loadingService.loadingChanged.subscribe(
      (isLoading: boolean) => {
        this.loading = isLoading;
      }
    );
  }

  onLogout() {
    this.usersService.logout().subscribe(
      data => {
        this.closeSession();
      },
      err => {
        // aunque el token no sea valido se cierra la sesion en el cliente
        this.closeSession();
      }
    );
  }

  closeSession() {
    this.usersService.authenticatedUser = null;

    localStorage.removeItem('currentUser');

    this.router.navigate(['/login']);
  }

  public showSidenav(): void {
    //this.sidenavParams = ['show'];
    this.sidenavActions.emit('sideNav');
  }

  public hideSidenav(): void {
    //this.sidenavParams = ['hide'];
    this.sidenavActions.emit('sideNav');
  }
}
