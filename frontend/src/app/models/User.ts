import { Apartment } from "./Apartment";

export class User {
    email: String
    fullName: String
    password: String
    id: String
    listedApartments: Apartment[]
    savedApartments: Apartment[]

    constructor(e: string, p: string, fName: string) {
        this.email = e
        this.password = p
        this.fullName = fName
    }
}