import { User } from "./User";

export class Apartment {
    id: string;
    numBeds: number;
    numBaths: number;
    address: string;
    userID: string;
    area: number;
    imgURL: string;
    price: number;
    utilDetails: string;
    restrictions: string;

    constructor(uID: string, beds: number, baths: number, address: string, area: number, img: string, price: number, util: string, rest: string) {
        this.userID = uID
        this.numBeds = beds
        this.numBaths = baths
        this.address = address
        this.area = area
        this.imgURL = img
        this.price = price
        this.utilDetails = util
        this.restrictions = rest
    }
}
