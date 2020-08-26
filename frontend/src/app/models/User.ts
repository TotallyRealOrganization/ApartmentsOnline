import { Apartment } from "./Apartment";

export class User {
    email: string
    fullName: string
    password: string
    id: string
    listedApartments: Apartment[]
    savedApartments: Apartment[]

    constructor(e: string, p: string, fName?: string) {
        this.email = e
        this.password = p
        if (fName) {
            this.fullName = fName
        }
    }
}