import { Apartment } from "./Apartment";

export class User {
    email: String
    fullName: String
    password: String
    id: String
    listedApartments: Apartment[]
    savedApartments: Apartment[]
}