import {DTO} from './DTO';

export class Order implements DTO {

  constructor(
    public description?: string,
    public startDate?: Date,
    public finishDate?: Date,
    public price?: number,
  ) {}

  public populateFromDTO(dto: any) {
    this.description = dto['description'];
    this.startDate = dto['startDate'];
    this.finishDate = dto['finishDate'];
    this.price = dto['price'];
  }

}
