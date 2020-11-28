import {DTO} from './DTO';

export class Handyman implements DTO {

  constructor(
    public id?: number,
    public name?: string,
    public createDate?: Date,
    public updateDate?: Date,
  ) {}

  public populateFromDTO(dto: any) {
    this.id = dto['id'];
    this.name = dto['name'];
    this.createDate = dto['createDate'];
    this.updateDate = dto['updateDate'];
  }

}
