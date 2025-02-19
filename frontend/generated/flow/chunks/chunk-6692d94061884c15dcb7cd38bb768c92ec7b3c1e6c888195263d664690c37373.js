import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import 'Frontend/styles/shared-styles.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import 'Frontend/generated/jar-resources/buttonFunctions.js';
import 'Frontend/generated/jar-resources/vaadin-zxing-reader.js';
import '@vaadin/custom-field/theme/lumo/vaadin-custom-field.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import { injectGlobalCss } from 'Frontend/generated/jar-resources/theme-util.js';

import { css, unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin';
import $cssFromFile_0 from 'Frontend/generated/jar-resources/vaadin-zxing.css?inline';

injectGlobalCss($cssFromFile_0.toString(), 'CSSImport end', document);