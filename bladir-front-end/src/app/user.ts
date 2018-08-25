export class User {
  uid: number;
  username: string;
  firstName: string;
  lastName: string;
  email: string;
  gender: string;
  roleId: number;

  constructor(
    uid: number,
    username: string,
    firstName: string,
    lastName: string,
    email: string,
    gender: string,
    roleId: number
  ) {
    this.uid = uid;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.roleId = roleId;
  }
}
