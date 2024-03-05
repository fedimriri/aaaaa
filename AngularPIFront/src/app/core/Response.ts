import { User } from "./User";
import { Complaint } from "./Complaint";

export class Response {
  idRep: number;
  description: string;
  responseDate: Date;
  ADMIN: User;
  complaint: Complaint;
}