import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl} from "@angular/forms";
import {HumidityService} from "../../services/humidity.service";
import {Humidity} from "../../models/humidity";
import {ErrorService} from "../../services/error.service";
import { Router } from '@angular/router';
import {MessageService} from "../../services/message.service";

@Component({
  selector: 'app-humidity-calculation',
  templateUrl: './humidity-calculation.component.html',
  styleUrls: ['./humidity-calculation.component.css']
})
export class HumidityCalculationComponent implements OnInit {

  constructor(private humidityService: HumidityService,
              private errorService: ErrorService,
              private messageService: MessageService,
              private fb: FormBuilder,
              private router: Router) { }

  humidityFormGroup = this.fb.group( {
    temperature: new FormControl(''),
    humidity: new FormControl(''),
  });

  ngOnInit(): void {
  }

  async calculateData(){
    const obs = this.humidityService.calculateHumidityValues(this.humidityFormGroup.value as Humidity) // TODO unsub
      .subscribe({
        next: (response: string) => {console.log(response); this.messageService.add(response);},
        error: (err: Error) => this.errorService.alertMessage(err.message),
        complete: () => this.router.navigate(['calc'])
      });
  }
}
