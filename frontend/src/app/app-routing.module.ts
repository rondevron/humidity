import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HumidityCalculationComponent } from './components/humidity-calculation/humidity-calculation.component';

const routes: Routes = [
  {
    path: 'calc',
    component: HumidityCalculationComponent
  },
  {
    path: '',
    component: HumidityCalculationComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
