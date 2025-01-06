import { injectGlobalWebcomponentCss } from 'Frontend/generated/jar-resources/theme-util.js';

import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';
import 'Frontend/generated/jar-resources/ReactRouterOutletElement.tsx';

const loadOnDemand = (key) => {
  const pending = [];
  if (key === 'bdc93fc4d0d5f597851667752edab23634be3e2dc29c42a579d4dc6138016a85') {
    pending.push(import('./chunks/chunk-a1cf7844fd858bac791a31d34ef8788d74e311bca731afdf70256abc874fc8b3.js'));
  }
  if (key === 'e51c3fcfd2c72e03019bd7155dac0d216ddf75c26a77a42daa70eb8f31966159') {
    pending.push(import('./chunks/chunk-0e9e2e6d0fd080c633d655da89b21ed6b6b39f86d2a7ed6542243caebaff09f8.js'));
  }
  if (key === 'a2731d124f3896bb13afb6dc810f90215bd124db8a04132710ac33b4360140d5') {
    pending.push(import('./chunks/chunk-433dcf1683329fe7f4d54789b6096669f9835a3a394f72f2390800d1e864ac9e.js'));
  }
  if (key === '31f2905028e756efd9a0f51e73b2081e2ff1099a23e83881e9ad7d7add871714') {
    pending.push(import('./chunks/chunk-6692d94061884c15dcb7cd38bb768c92ec7b3c1e6c888195263d664690c37373.js'));
  }
  if (key === '65fe4756aab6ad737ae6064e1b0ce150bf263e7b6dcc18a512ff855458a6b1d2') {
    pending.push(import('./chunks/chunk-1c80d99fba7f588171736756989ad3ad8867d8bab51efb21c19e1eac73e73fc1.js'));
  }
  if (key === '6aa2a35332bb4047a88aaebfcc1c42ff9481122398f0331c8a7dc9389c15c737') {
    pending.push(import('./chunks/chunk-0f40665f6a36d2a1e89c44c8a7aa70f3805b8ae8d1acac661e3f2ac08a3230b1.js'));
  }
  if (key === 'b91d6af389c7aa07a106f80f6e4157ff289a86c9c62aa59065083f0eddb91c02') {
    pending.push(import('./chunks/chunk-a1cf7844fd858bac791a31d34ef8788d74e311bca731afdf70256abc874fc8b3.js'));
  }
  if (key === '6f9400c4529b1b31b79177c4c1b23566818dab4f6484426eebf276b8eb9c102a') {
    pending.push(import('./chunks/chunk-577f019df0480dcc8a65d41ce54ae730fac3467f24b6d6694d5ff876d0b6fac2.js'));
  }
  if (key === '50fb8513cab3fc78cd63ef667bac7e5acff0de1fba3432a8499c91655774387c') {
    pending.push(import('./chunks/chunk-1c80d99fba7f588171736756989ad3ad8867d8bab51efb21c19e1eac73e73fc1.js'));
  }
  if (key === '9a25fa6fb0c42c15116f29c4190efcb831fc0a177cc7954dbb49e9630ceae1a7') {
    pending.push(import('./chunks/chunk-57533f5af8e21749d541e799bfb69ae2ba7afc34d233927f440130272f97fa21.js'));
  }
  if (key === '5c4b0c0018dedbcb11950716ab187f6de9620f3661b1301af6da87540475637f') {
    pending.push(import('./chunks/chunk-aa8813da4137f1e85b198e07577da3e61e8cc4624f6dd24aeb8e0deba81d384e.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;
window.Vaadin.Flow.resetFocus = () => {
 let ae=document.activeElement;
 while(ae&&ae.shadowRoot) ae = ae.shadowRoot.activeElement;
 return !ae || ae.blur() || ae.focus() || true;
}