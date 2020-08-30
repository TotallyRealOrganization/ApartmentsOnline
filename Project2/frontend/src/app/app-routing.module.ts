import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateListingComponent } from './components/views/create-listing/create-listing.component';
import { ApartmentDetailsComponent } from './components/views/apartment-details/apartment-details.component';
import { LoginComponent } from './components/views/login/login.component';
import { PostedApartmentsComponent } from './components/views/posted-apartments/posted-apartments.component';
import { SavedApartmentsComponent } from './components/views/saved-apartments/saved-apartments.component';
import { AllListingsComponent } from './components/views/all-listings/all-listings.component';
import { HomeComponent } from './components/views/home/home.component';
import { RegisterComponent } from './components/views/register/register.component';

const routes: Routes = [
  { path: 'create-listing', component: CreateListingComponent},
  { path: 'apartment-details', component: ApartmentDetailsComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'posted-apartments', component: PostedApartmentsComponent},
  { path: 'saved-apartments', component: SavedApartmentsComponent},
  { path: 'all-listings', component: AllListingsComponent},
  { path: "**", component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }