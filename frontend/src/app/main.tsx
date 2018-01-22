import * as preact from "preact";
import { MainContainer } from "./containers/main/mainContainer";
import { mainStore } from "./store/main";

type Config = {
  backendUrl: string
};

export function onLoad(config: Config) {
  console.log("App successfully loaded!", config);
  const container = document.createElement("div");
  document.body.appendChild(container);
  preact.render(<MainContainer store={mainStore}/>, container);
}

// Install the app entry point.
(function () {
  (window as any).startApp = onLoad;
})();
