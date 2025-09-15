import { Given, When, Then, Before, After } from '@cucumber/cucumber';
import { chromium, Page, Browser, expect } from '@playwright/test';
import Login from '../pages/Login.ts';
import Inventario from '../pages/Inventario.ts';
import Pago from '../pages/Pago.ts';
import assert from "assert";

let browser: Browser;
let page: Page;
let loginPage: Login;
let inventoryPage: Inventario;
let checkoutPage: Pago;


Given("que estoy en la página de login", async function () {
  browser = await chromium.launch({ headless: false, slowMo: 500 }); 
  const context = await browser.newContext();
  page = await context.newPage();
  loginPage = new Login(page);
  inventoryPage = new Inventario(page);
  checkoutPage = new Pago(page);
  await loginPage.goto();
});

When('inicio sesión con el usuario {string} y contraseña {string}', async (username, password) => {
  await loginPage.login(username, password);
});

Then("debo ver el inventario de productos", async function () {
  const visible = await loginPage.InventarioVisible();
  assert.strictEqual(visible, true, "No se mostró la lista de productos");
});

When('agrego un producto al carrito', async () => {
  await inventoryPage.AgregarAlCarroPrimerItem();
});

When('agrego el producto {string} al carrito', async (NombreProducto: string) => {
  await inventoryPage.AgregarAlCarro(NombreProducto);
});

Then('ingreso al carro de compra', async () => {
  await inventoryPage.CarroCompra();
});

When('completo el checkout con los datos de nombre {string}, apellido {string} y zip {string}', async (nombre, apellido, zip) => { 
  await page.click('[data-test="checkout"]');
  await checkoutPage.IngresarInfoComprador(nombre, apellido, zip);
  await checkoutPage.Finalizar();
});

Then('debería ver el mensaje {string}', async (mensaje) => {
  const text = await checkoutPage.getSuccessMessage();
  await expect(text).toHaveText(mensaje);
});

Then('debería ver el mensaje de error {string}', async (mensaje) => {
  const error = await loginPage.getErrorMessage();
  await expect(error).toHaveText(mensaje);
});
