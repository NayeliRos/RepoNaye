import type { Page } from '@playwright/test';

export default class Login {
  constructor(private page: Page) {}

  async goto() {
    await this.page.goto('https://www.saucedemo.com/');
  }

  async login(username: string, password: string) {
    await this.page.fill('[data-test="username"]', username);
    await this.page.fill('[data-test="password"]', password);
    await this.page.click('[data-test="login-button"]');
  }

  async getErrorMessage() {
    return this.page.locator('[data-test="error"]');
  }

  async InventarioVisible(): Promise<boolean> {
    return this.page.isVisible(".inventory_list");
  }
}