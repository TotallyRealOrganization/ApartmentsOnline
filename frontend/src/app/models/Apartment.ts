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

    constructor(beds: number, baths: number, address: string, area: number, img: string, price: number, util: string, rest: string) {
        this.numBaths = beds
        this.numBaths = baths
        this.address = address
        this.area = area
        this.imgURL = img
        this.price = price
        this.utilDetails = util
        this.restrictions = rest

        

    }
}
