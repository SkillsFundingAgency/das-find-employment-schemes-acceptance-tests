import { browser } from 'k6/experimental/browser';

export const options = {
  scenarios: {
    ui: {
      executor: 'shared-iterations',
      options: {
        browser: {
          type: 'chromium',
        },
      },
    },
  },
}

export default async function () {
  const page = browser.newPage();


  try {
    await page.goto('');
    page.screenshot({ path: 'screenshots/screenshot.png' });
  } finally {
    page.close();
  }
}

