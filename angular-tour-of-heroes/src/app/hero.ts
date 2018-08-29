export class Hero {
  id: number;
  name: string;

  public toStrings(): String {
    return `Hero id: ${this.id} name: ${this.name}`;
  }
}
