import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/membre.service';
import { User } from '../model/membre';

@Component({
  selector: 'app-membre-form',
  templateUrl: './membre-form.component.html',
  styleUrls: ['./membre-form.component.css']
})
export class MembreFormComponent implements OnInit {

	membre:Membre;
  constructor(private route: ActivatedRoute, private router: Router, private membreService: MembreService) { 
  	this.membre = new Membre();
  }

  onSubmit() {
  	this.membreService.save(this.membre).subscribe(result => this.goToMembreList());
  }

  goToMembreList() {
  	this.router.navigate(['/membres']);
  }

  ngOnInit() {
  }

}
