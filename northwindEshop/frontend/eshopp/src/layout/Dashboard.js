import { Button, GridColumn, Icon, Label } from "semantic-ui-react";
import Navi from "./Navi";
import Categories from "./Categories";
import ProductList from "../page/ProductList";
import { Grid, Image } from "semantic-ui-react";

function Dashboard() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <GridColumn width={4}>
            <Categories />
          </GridColumn>
          <GridColumn width={12} >
            <ProductList />
          </GridColumn>
        </Grid.Row>
      </Grid>
    </div>
  );
}

export default Dashboard;
