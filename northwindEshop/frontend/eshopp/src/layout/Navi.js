import { Button, Dropdown, Menu } from "semantic-ui-react";
import CartSummary from "./CartSummary";
function Navi() {
  return (
    <div>
      <Menu size="massive" inverted>
        <Menu.Item name="home" />
        <Menu.Item name="messages" />

        <Menu.Menu position="right">
          <CartSummary />

          <Menu.Item>
            <Button primary>Sign Up</Button>
          </Menu.Item>
        </Menu.Menu>
      </Menu>
    </div>
  );
}

export default Navi;
