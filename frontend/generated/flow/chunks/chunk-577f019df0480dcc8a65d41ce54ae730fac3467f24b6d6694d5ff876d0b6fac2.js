import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/tabs/theme/lumo/vaadin-tab.js';
import '@vaadin/icon/theme/lumo/vaadin-icon.js';
import '@vaadin/icons/vaadin-iconset.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-item.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-layout.js';
import '@vaadin/tabs/theme/lumo/vaadin-tabs.js';
import 'Frontend/styles/shared-styles.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import '@vaadin/app-layout/theme/lumo/vaadin-app-layout.js';
import { injectGlobalCss } from 'Frontend/generated/jar-resources/theme-util.js';

import { css, unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin';
import $cssFromFile_0 from 'Frontend/styles/views/app.css?inline';

injectGlobalCss($cssFromFile_0.toString(), 'CSSImport end', document);