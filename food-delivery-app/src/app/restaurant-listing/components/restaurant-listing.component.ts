import { Component } from '@angular/core';
import { Restaurant } from 'src/app/Shared/models/Restaurant';
import { Router } from '@angular/router';
import { RestaurantService } from '../service/restaurant.service';

@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrls: ['./restaurant-listing.component.css']
})
export class RestaurantListingComponent {

  public restaurantList: Restaurant[];
  public ramdonImageUrl: string[] = [];

  ngOnInit() {
    this.getAllRestaurants();
  }

  constructor(private router: Router, private restaurantService: RestaurantService) {}

  getAllRestaurants(){ 
    this.restaurantService.getAllRestaurants().subscribe(data => {
      this.restaurantList = data;
      this.restaurantList.forEach(restaurant => {
        this.ramdonImageUrl.push('assets/restaurant-pics/' + this.getRadomImage());
      });
    });
  }

  getRamdonNumber(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  getRadomImage(): string {
    const imageCount = 8; 
    const ramdonNum = this.getRamdonNumber(1, imageCount);
    return `${ramdonNum}.jpg`;
  }

  onButtonClick(id: number){
    this.router.navigate(['/food-catalogo', id]);
  }
}
