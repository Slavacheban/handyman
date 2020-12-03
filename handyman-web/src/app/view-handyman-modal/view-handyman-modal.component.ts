import {Component, OnInit} from '@angular/core';
import {BsModalRef} from "ngx-bootstrap/modal";
import {Handyman} from "../shared/entities/handyman";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HandymanService} from "../shared/services/handyman-service";

@Component({
  selector: 'app-view-handyman-modal',
  templateUrl: './view-handyman-modal.component.html',
  styleUrls: ['./view-handyman-modal.component.scss']
})
export class ViewHandymanModalComponent implements OnInit {
  public id: number;
  public handyman: Handyman;
  public isLoading: boolean;

  public handymanForm: FormGroup;

  constructor(private bsModalRef: BsModalRef,
              private formBuilder: FormBuilder,
              private handymanService: HandymanService) {
    this.handyman = new Handyman();
  }

  ngOnInit() {
    this.handymanForm = this.formBuilder.group({
      name: ['', Validators.compose([Validators.required])],
    });
  }

  close() {
    if (this.bsModalRef.content.callback != null) {
      this.bsModalRef.content.callback(false);
      this.bsModalRef.hide();
    }
  }

  async save() {
    this.isLoading = true;
    this.handyman.userId = 1;
    this.handymanService.addHandyman(this.handyman).then((resp) => {
      this.isLoading = false;
      this.bsModalRef.content.callback(true);
      this.bsModalRef.hide();
    });
  }

  async getCashPoolById() {

  }

}
