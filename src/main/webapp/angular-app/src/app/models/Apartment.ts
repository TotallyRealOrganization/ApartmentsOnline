import { User } from "./User";
import { Amenities } from "./Amenties"

export class Apartment {
    numBeds: number;
    numBaths: number;
    address: string;
    owner: User;
    area: number;
    imgURL: string;
    price: number;
    amenities: Amenities;
    utilDetails: string;
    restrictions: string;
}
