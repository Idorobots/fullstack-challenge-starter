import * as preact from "preact";
import * as main from "./main";

describe("main", () => {
  it("should render stuff", () => {
    spyOn(preact, "render");
    main.onLoad({
      backendUrl: "localhost:1234"
    });
    expect(preact.render).toHaveBeenCalled();
  });
});
