import { User } from "./User";
import { Amenities } from "./Amenties"

export class Apartment {
    owner: User
    area: Number
    imgURL: String
    price: Number
    amenities: Amenities
    utilDetails: String
    restrictions: String
}