import { Foodcategory } from "./FoodCategory";
import { Restaurent } from "./Restaurent";

export class Food {
    fid: number;
    name: string;
    price: Number;
    category: Foodcategory;
    imagePath:string;
    selectedRestaurent: Restaurent;
    
    constructor(){}
}