import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PentahoService } from './pentaho.service';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { map } from 'rxjs/operator/map';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-reports-dashboard',
  templateUrl: './reports-dashboard.component.html',
  styleUrls: ['./reports-dashboard.component.css']
})
export class ReportsDashboardComponent implements OnInit {
  id: string;
  url: string;
  securedUrl: any;
  panels: any[];

  constructor(private route: ActivatedRoute,
    private sanitizer: DomSanitizer) {
  }

  ngOnInit() {
    this.initPanels();

    this.route.params.subscribe(
      params => {
        this.id = params['id'];
        if (this.id) {
          const panel = this.panels.filter(panel => panel.link === this.id)[0];
          if (panel) {
            console.log(environment.pentaho_url + panel.url);
            this.url = environment.pentaho_url + panel.url;
          }
          this.securedUrl = this.sanitizer.bypassSecurityTrustResourceUrl(this.url);
        } else {
            this.securedUrl = null;
        }
      }
    );
  }

  initPanels() { 
    this.panels = [
      {
        img: '/rug-adm/assets/img/analytics-blur-chart-590020.jpg',
        title: 'Tramites',
        link: 'tra',
        url: '/api/repos/%3Ahome%3A20190710-tramites.wcdf/generatedContent?userid=Admin&password=password'
      },
      {
        img: '/rug-adm/assets/img/analytics-blur-chart-590020.jpg',
        title: 'Personas',
        link: 'per',
        url: '/api/repos/%3Ahome%3A20190710-personas.wcdf/generatedContent?userid=Admin&password=password'
      },
      {
        img: '/rug-adm/assets/img/analytics-blur-chart-590020.jpg',
        title: 'Pagos',
        link: 'pag',
        url: '/api/repos/%3Ahome%3A20190710-pagos.wcdf/generatedContent?userid=Admin&password=password'
      },
      {
        img: '/rug-adm/assets/img/analytics-blur-chart-590020.jpg',
        title: 'Tipo bien especial',
        link: 'tb',
        url: '/api/repos/%3Ahome%3A20190710-tipo-bien.wcdf/generatedContent?userid=Admin&password=password'
      },
      {
        img: '/rug-adm/assets/img/analytics-blur-chart-590020.jpg',
        title: 'Tipo persona',
        link: 'tp',
        url: '/api/repos/%3Ahome%3A20190710-tipo-persona.wcdf/generatedContent?userid=Admin&password=password'
      },
      {
        img: '/rug-adm/assets/img/analytics-blur-chart-590020.jpg',
        title: 'Monto garantizado',
        link: 'mg',
        url: '/api/repos/%3Ahome%3A20190808-monto-garantizado.wcdf/generatedContent?userid=Admin&password=password'
      },
      {
        img: '/rug-adm/assets/img/analytics-blur-chart-590020.jpg',
        title: 'Bienes en garantia',
        link: 'bg',
        url: '/api/repos/%3Ahome%3A20190710-bienes-garantia.wcdf/generatedContent?userid=Admin&password=password'
      }
    ];
  }
}
