import {DTO} from './DTO';

export class User implements DTO {

  constructor(
    public name?: string,
    public email?: string,
    public password?: string,
  ) {}

  public populateFromDTO(dto: any) {
    this.name = dto['name'];
    this.email = dto['email'];
    this.password = dto['password'];
  }

}
