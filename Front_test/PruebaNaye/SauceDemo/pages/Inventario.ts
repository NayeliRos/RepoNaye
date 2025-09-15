import type { Page } from '@playwright/test';

export default class Inventario {
  constructor(private page: Page) {}

  async AgregarAlCarroPrimerItem() {
    await this.page.click('[data-test="add-to-cart-sauce-labs-backpack"]');
  }

  async AgregarAlCarro(NombreProducto: string) {
    const Producto = this.page.locator(".inventory_item").filter({
      hasText: NombreProducto
    })
    await Producto.locator("button").click();
  }

  async CarroCompra() {
    await this.page.click('.shopping_cart_link');
  }
}
