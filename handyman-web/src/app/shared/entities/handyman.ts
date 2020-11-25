import {DTO} from './DTO';

export class Handyman implements DTO {

  constructor(
    public name?: string,
  ) {}

  public populateFromDTO(dto: any) {
    this.name = dto['name'];
  }

}
