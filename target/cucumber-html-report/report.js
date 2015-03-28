$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test-userAcceptance/resources/com/learn/bdd/UserAcceptanceTest/VendingMachine.feature");
formatter.feature({
  "id": "buying-a-drink-from-vending-machine",
  "description": "\nIn order to buy a drink\nAs a Vending Machine user\nI want to pay the exact price listed",
  "name": "Buying a drink from Vending Machine",
  "keyword": "Feature",
  "line": 1
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 7,
  "type": "background"
});
formatter.step({
  "name": "stock for \u003cDrink\u003e exist",
  "keyword": "Given ",
  "line": 8,
  "rows": [
    {
      "cells": [
        "Drink",
        "Stock",
        "Price"
      ],
      "line": 9
    },
    {
      "cells": [
        "water",
        "20",
        "1.0"
      ],
      "line": 10
    },
    {
      "cells": [
        "softdrink",
        "10",
        "1.25"
      ],
      "line": 11
    },
    {
      "cells": [
        "juice",
        "15",
        "1.50"
      ],
      "line": 12
    }
  ]
});
formatter.match({
  "location": "VendingMachineSteps.stock_for_Drink_exist(DataTable)"
});
formatter.result({
  "duration": 138026000,
  "status": "passed"
});
formatter.scenario({
  "id": "buying-a-drink-from-vending-machine;buy-any-valid-drink-for-the-exact-price-displayed-on-vending-machine",
  "description": "",
  "name": "Buy any valid drink for the exact price displayed on vending machine",
  "keyword": "Scenario",
  "line": 14,
  "type": "scenario"
});
formatter.step({
  "name": "User puts in exact change for the price and selects the drink",
  "keyword": "When ",
  "line": 15
});
formatter.step({
  "name": "Vending Machine should deliver the requested drink",
  "keyword": "Then ",
  "line": 16
});
formatter.step({
  "name": "the stock for the drink must be auto decremented",
  "keyword": "And ",
  "line": 17
});
formatter.match({
  "location": "VendingMachineSteps.user_puts_in_exact_change_for_the_price_and_selects_the_drink()"
});
formatter.result({
  "duration": 554000,
  "status": "passed"
});
formatter.match({
  "location": "VendingMachineSteps.vending_Machine_should_deliver_the_requested_drink()"
});
formatter.result({
  "duration": 3564000,
  "status": "passed"
});
formatter.match({
  "location": "VendingMachineSteps.the_stock_for_the_drink_must_be_auto_decremented()"
});
formatter.result({
  "duration": 42000,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 7,
  "type": "background"
});
formatter.step({
  "name": "stock for \u003cDrink\u003e exist",
  "keyword": "Given ",
  "line": 8,
  "rows": [
    {
      "cells": [
        "Drink",
        "Stock",
        "Price"
      ],
      "line": 9
    },
    {
      "cells": [
        "water",
        "20",
        "1.0"
      ],
      "line": 10
    },
    {
      "cells": [
        "softdrink",
        "10",
        "1.25"
      ],
      "line": 11
    },
    {
      "cells": [
        "juice",
        "15",
        "1.50"
      ],
      "line": 12
    }
  ]
});
formatter.match({
  "location": "VendingMachineSteps.stock_for_Drink_exist(DataTable)"
});
formatter.result({
  "duration": 1506000,
  "status": "passed"
});
formatter.scenario({
  "id": "buying-a-drink-from-vending-machine;buy-an-invalid-drink-from-vending-machine",
  "tags": [
    {
      "name": "@BuyAnInvalidDrinkFromVendingMachine",
      "line": 19
    }
  ],
  "description": "",
  "name": "Buy an invalid drink from vending machine",
  "keyword": "Scenario",
  "line": 20,
  "type": "scenario"
});
formatter.step({
  "name": "User wants to buy an invalid \u003cDrink\u003e",
  "keyword": "When ",
  "line": 21,
  "rows": [
    {
      "cells": [
        "Drink",
        "Stock",
        "Price"
      ],
      "line": 22
    },
    {
      "cells": [
        "vitamindrink",
        "8",
        "2.00"
      ],
      "line": 23
    }
  ]
});
formatter.step({
  "name": "Vending Machine should alert the user with exception \"invalid drink\"",
  "keyword": "Then ",
  "line": 24
});
formatter.match({
  "location": "VendingMachineSteps.user_wants_to_buy_an_invalid_drink(DataTable)"
});
formatter.result({
  "duration": 447000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "invalid drink",
      "offset": 54
    }
  ],
  "location": "VendingMachineSteps.vending_Machine_should_alert_the_user_with_exception(String)"
});
formatter.result({
  "duration": 3592000,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 7,
  "type": "background"
});
formatter.step({
  "name": "stock for \u003cDrink\u003e exist",
  "keyword": "Given ",
  "line": 8,
  "rows": [
    {
      "cells": [
        "Drink",
        "Stock",
        "Price"
      ],
      "line": 9
    },
    {
      "cells": [
        "water",
        "20",
        "1.0"
      ],
      "line": 10
    },
    {
      "cells": [
        "softdrink",
        "10",
        "1.25"
      ],
      "line": 11
    },
    {
      "cells": [
        "juice",
        "15",
        "1.50"
      ],
      "line": 12
    }
  ]
});
formatter.match({
  "location": "VendingMachineSteps.stock_for_Drink_exist(DataTable)"
});
formatter.result({
  "duration": 1650000,
  "status": "passed"
});
formatter.scenario({
  "id": "buying-a-drink-from-vending-machine;buy-a-valid-drink-for-lesser-amount-than-the-expected-price",
  "tags": [
    {
      "name": "@BuyAValidDrinkForLessAmountThanPrice",
      "line": 26
    }
  ],
  "description": "",
  "name": "Buy a valid drink for lesser amount than the expected price",
  "keyword": "Scenario",
  "line": 27,
  "type": "scenario"
});
formatter.step({
  "name": "User puts in \"lesser amount\" than the price and selects the \u003cDrink\u003e",
  "keyword": "When ",
  "line": 28,
  "rows": [
    {
      "cells": [
        "Drink",
        "Stock",
        "Price"
      ],
      "line": 29
    },
    {
      "cells": [
        "water",
        "20",
        "0.50"
      ],
      "line": 30
    },
    {
      "cells": [
        "softdrink",
        "10",
        "1.00"
      ],
      "line": 31
    },
    {
      "cells": [
        "juice",
        "15",
        "1.25"
      ],
      "line": 32
    }
  ]
});
formatter.step({
  "name": "Vending Machine should alert the user with exception \"insufficient funds\"",
  "keyword": "Then ",
  "line": 33
});
formatter.match({
  "arguments": [
    {
      "val": "lesser amount",
      "offset": 14
    }
  ],
  "location": "VendingMachineSteps.user_puts_in_than_the_price_and_selects_the_Drink(String,DataTable)"
});
formatter.result({
  "duration": 1720000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "insufficient funds",
      "offset": 54
    }
  ],
  "location": "VendingMachineSteps.vending_Machine_should_alert_the_user_with_exception(String)"
});
formatter.result({
  "duration": 67000,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 7,
  "type": "background"
});
formatter.step({
  "name": "stock for \u003cDrink\u003e exist",
  "keyword": "Given ",
  "line": 8,
  "rows": [
    {
      "cells": [
        "Drink",
        "Stock",
        "Price"
      ],
      "line": 9
    },
    {
      "cells": [
        "water",
        "20",
        "1.0"
      ],
      "line": 10
    },
    {
      "cells": [
        "softdrink",
        "10",
        "1.25"
      ],
      "line": 11
    },
    {
      "cells": [
        "juice",
        "15",
        "1.50"
      ],
      "line": 12
    }
  ]
});
formatter.match({
  "location": "VendingMachineSteps.stock_for_Drink_exist(DataTable)"
});
formatter.result({
  "duration": 1651000,
  "status": "passed"
});
formatter.scenario({
  "id": "buying-a-drink-from-vending-machine;buy-a-valid-drink-for-more-amount-than-the-expected-price",
  "tags": [
    {
      "name": "@BuyAValidDrinkForMoreAmountThanPrice",
      "line": 35
    }
  ],
  "description": "",
  "name": "Buy a valid drink for more amount than the expected price",
  "keyword": "Scenario",
  "line": 36,
  "type": "scenario"
});
formatter.step({
  "name": "User puts in \"greater amount\" than the price and selects the \u003cDrink\u003e",
  "keyword": "When ",
  "line": 37,
  "rows": [
    {
      "cells": [
        "Drink",
        "Stock",
        "Price"
      ],
      "line": 38
    },
    {
      "cells": [
        "water",
        "20",
        "1.25"
      ],
      "line": 39
    },
    {
      "cells": [
        "softdrink",
        "10",
        "1.75"
      ],
      "line": 40
    },
    {
      "cells": [
        "juice",
        "15",
        "2.25"
      ],
      "line": 41
    }
  ]
});
formatter.step({
  "name": "Vending Machine should alert the user with exception \"exact funds needed\"",
  "keyword": "Then ",
  "line": 42
});
formatter.match({
  "arguments": [
    {
      "val": "greater amount",
      "offset": 14
    }
  ],
  "location": "VendingMachineSteps.user_puts_in_than_the_price_and_selects_the_Drink(String,DataTable)"
});
formatter.result({
  "duration": 1381000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "exact funds needed",
      "offset": 54
    }
  ],
  "location": "VendingMachineSteps.vending_Machine_should_alert_the_user_with_exception(String)"
});
formatter.result({
  "duration": 56000,
  "status": "passed"
});
});