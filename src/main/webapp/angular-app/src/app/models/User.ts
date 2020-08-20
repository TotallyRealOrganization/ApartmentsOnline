import { Apartment } from "./Apartment";

export class User {
    username: String
    fullName: String
    password: String
    id: String
    listedApartments: Apartment[]
    savedApartments: Apartment[]
}