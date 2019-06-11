import { Component, OnInit } from '@angular/core';
import { Membre } from '../model/membre';
import { MembreService } from '../service/membre.service';

@Component({
	selector: 'app-membre-list',
	templateUrl: './membre-list.component.html',
	styleUrls: ['./membre-list.component.css']
})
export class MembreListComponent implements OnInit {
	membres : Membre[];
	constructor(private membreService : MembreService) { }

	ngOnInit() {
		this.membreService.findAll().subscribe(data => {
			this.membres = data;
		});
	}

}
