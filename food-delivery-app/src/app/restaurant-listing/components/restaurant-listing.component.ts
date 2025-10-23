import { Component } from '@angular/core';
import { Restaurant } from 'src/app/Shared/models/Restaurant';
import { RestaurantService } from '../service/restaurant.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrls: ['./restaurant-listing.component.css']
})
export class RestaurantListingComponent {

  public restaurantList: Restaurant[];
  public randomImageUrl: string[] = [];
 
  ngOnInit() {
    this.getAllRestaurants();
  }

  constructor(private router: Router, private restaurantService: RestaurantService) { }

  getAllRestaurants() {
    this.restaurantService.getAllRestaurants().subscribe(
      data => {
        this.restaurantList = data;
        this.restaurantList.forEach(restaurant => {
          this.randomImageUrl.push('assets/restaurant-pics/' + this.getRandomImage());
        });
      }
    )
  }
  
  getRandomNumber(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }
  
  getRandomImage(): string {
    const imageCount = 8; 
    const randomIndex = this.getRandomNumber(1, imageCount);
    return `${randomIndex}.jpg`; 
  }

  onButtonClick(id: number) {
    this.router.navigate(['/food-catalogue', id]);
  }

}