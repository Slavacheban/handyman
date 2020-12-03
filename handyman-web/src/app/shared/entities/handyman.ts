import {DTO} from './DTO';
import {User} from "./user";

export class Handyman implements DTO {

  constructor(
    public id?: number,
    public createDate?: Date,
    public updateDate?: Date,
    public userId?: number,
    public userDTO?: User,
    public _name?: string,
  ) {}

  public populateFromDTO(dto: any) {
    this.id = dto['id'];
    this.createDate = dto['createDate'];
    this.updateDate = dto['updateDate'];
    this.userId = dto['userId'];
    this.userDTO = dto['userDTO'];
  }

}
