import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-img',
  templateUrl: './img.component.html',
  styleUrls: ['./img.component.scss']
})
export class ImgComponent {

  @Input() imagen: string;
  @Output() loaded = new EventEmitter<string>();

  imgDefault = 'https://www.m2crowd.com/core/i/placeholder.png';

  noExistImg() {
    this.imagen = this.imgDefault;
  }

  imgLoaded() {
    this.loaded.emit(this.imagen);
  }
}
