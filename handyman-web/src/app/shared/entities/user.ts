import {DTO} from './DTO';

export class User implements DTO {

  constructor(
    public firstName?: string,
    public lastName?: string,
    public email?: string,
    public password?: string,
  ) {}

  public populateFromDTO(dto: any) {
    this.firstName = dto['firstName'];
    this.lastName = dto['lastName'];
    this.email = dto['email'];
    this.password = dto['password'];
  }

}
