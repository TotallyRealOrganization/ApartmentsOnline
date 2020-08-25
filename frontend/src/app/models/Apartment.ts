import { User } from "./User";

export class Apartment {
    id: String;
    numBeds: number;
    numBaths: number;
    address: string;
    owner: User;
    area: number;
    imgURL: string;
    price: number;
    utilDetails: string;
    restrictions: string;
}
