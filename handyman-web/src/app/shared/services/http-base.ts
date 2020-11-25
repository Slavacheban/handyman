import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {DTO} from "../entities/DTO";

export class HttpBase {


  constructor(private httpClient: HttpClient) {
  }

  protected getOne<T extends DTO>(
    url: string,
    dtoType: new () => T,
    params?: { [param: string]: string }): Observable<T> {

    return this.httpClient.get(url, {params: params}).pipe(
      map((data: any) => {
        let entity: T;
        if (data) {
          entity = new dtoType();
          entity.populateFromDTO(data);
        }
        return entity;
      })
    );
  }

  protected getAny(
    url: string,
    params?: { [param: string]: string }): Observable<any> {
    return this.httpClient.get(url, {params: params});
  }


  protected getFile<Blob>(
    url: string,
    params?: { [param: string]: string }): Observable<any> {
    return this.httpClient.get<Blob>(url, {params: params, responseType: 'blob' as 'json'}
    );
  }

  protected postFile<Blob>(
    url: string,
    body?: any,
    params?: { [param: string]: any }): Observable<any> {
    return this.httpClient.post<Blob>(url, body, {params: params, responseType: 'blob' as 'json'}
    );
  }

  protected getAll<T extends DTO>(
    url: string,
    dtoType: new () => T,
    params?: { [param: string]: string }): Observable<T[]> {

    return this.httpClient.get(url, {params: params}).pipe(
      map((dataArray: any[]) => {
        return dataArray.map((_d: T) => {
          let entity: T = new dtoType();
          entity.populateFromDTO(_d);
          return entity;
        });
      })
    );
  }

  protected getAllForSimpleTypeResults<T>(
    url: string,
    params?: { [param: string]: string }): Observable<T[]> {

    return this.httpClient.get(url, {params: params}).pipe(
      map((dataArray: any[]) => dataArray)
    );
  }

  protected postForSimpleTypeResults<T>(
    url: string,
    params?: { [param: string]: string },
    payload?: any): Observable<T[]> {

    return this.httpClient.post(url, payload, {params: params}).pipe(
      map((dataArray: any[]) => dataArray)
    );
  }

  protected post<T extends DTO>(
    url: string,
    dtoType: new () => T,
    urlParams?: { [param: string]: string },
    payload?: any): Observable<any> {

    return this.httpClient.post(url, payload, {params: urlParams});
  }

  protected postForMultipleResults<T extends DTO>(
    url: string,
    dtoType: new () => T,
    urlParams?: { [param: string]: string },
    payload?: any): Observable<T[]> {

    return this.httpClient.post(url, payload, {params: urlParams}).pipe(
      map((dataArray: any[]) => {
        return dataArray.map((_d: T) => {
          let entity: T = new dtoType();
          entity.populateFromDTO(_d);
          return entity;
        });
      })
    );
  }

  protected postForResult<T extends DTO>(
    url: string,
    dtoType: new () => T,
    urlParams?: { [param: string]: string },
    payload?: any): Observable<T> {

    return this.httpClient.post(url, payload, {params: urlParams}).pipe(
      map((data: any[]) => {
        let entity: T = new dtoType();
        entity.populateFromDTO(data);
        return entity;
      })
    );
  }

  protected getOneResponseStatus(
    url: string,
    params?: { [param: string]: string }): Observable<any> {
    return this.httpClient.get(url, {params: params, observe: 'response'}).pipe(
      map(response => {
          return response.status;
        }
      )
    );
  }

  protected postForResponseStatus(
    url: string,
    payload?: any,
    params?: { [param: string]: string }
  ): Observable<any> {
    return this.httpClient.post(url, payload, {params: params, observe: 'response'}).pipe(
      map(response => {
          return response.status;
        }
      )
    );
  }
}
