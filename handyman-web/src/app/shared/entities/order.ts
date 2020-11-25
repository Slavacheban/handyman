import {DTO} from './DTO';

export class Order implements DTO {

  constructor(
    public name?: string,
  ) {}

  public populateFromDTO(dto: any) {
    this.name = dto['name'];
  }

}
