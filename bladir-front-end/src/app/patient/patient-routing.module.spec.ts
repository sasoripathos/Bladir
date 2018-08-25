import { PatientRoutingModule } from './patient-routing.module';

describe('PatientRoutingModule', () => {
  let patientRoutingModule: PatientRoutingModule;

  beforeEach(() => {
    patientRoutingModule = new PatientRoutingModule();
  });

  it('should create an instance', () => {
    expect(patientRoutingModule).toBeTruthy();
  });
});
