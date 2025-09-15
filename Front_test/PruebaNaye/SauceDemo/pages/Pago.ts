import type { Page } from '@playwright/test';

export default class Pago {
  constructor(private page: Page) {}

  async IngresarInfoComprador(nombre: string, apellido: string, zip: string) {
    await this.page.fill('[data-test="firstName"]', nombre);
    await this.page.fill('[data-test="lastName"]', apellido);
    await this.page.fill('[data-test="postalCode"]', zip);
    await this.page.click('[data-test="continue"]');
  }

  async Finalizar() {
    await this.page.click('[data-test="finish"]');
  }

  async getSuccessMessage() {
    return this.page.locator('.complete-header');
  }
}
