# BOOM

## Case Study (Net Cafe) 
Net cafe “Boom” require a program to calculate rental with condition below:

Usage will be split into 3 type, which is browsing, typing and game
- Browsing hourly rate is $4
- Typing hourly rate is $2
- Gaming hourly rate it $6

Minimum usage is 30 minutes

After that, the cost will be calculated per minute

There are other facilities at the cafe

- Scan: $1 / page

- Print B/W: $0.5 / page

- Print Color: $0.8 / page

- Drink: $1.5 / bottle

TAKE NOTE: NO DATABASE 

## Start Application
Pull the project and run
```$xslt
git pull origin master
```

## Task List
- [x] Backend API
- [ ] Unit Test
- [ ] Frontend Design/ Integration

## API List
###1./1.0/accept/order (JSON)

This API will receive order and return order amount

**Request** 

  <table>
    <thead>
      <tr>
        <th>Key</th>
        <th>Data Type</th>
        <th>Description</th>
        <th>Required</th>
        <th>Sample</th>
      </tr>
    </thead>
    <tbody>
        <tr>
            <td>quantity</td>
            <td>String</td>
            <td>Indicate the order quantity, in number format, minimun value is 1</td>
            <td>M</td>
            <td>1</td>
        </tr>
        <tr>
            <td>action</td>
            <td>ActionEnum</td>
            <td>Indicate the request action, can be ADD or REMOVE</td>
            <td>M</td>
            <td>ADD</td>
        </tr>
        <tr>
            <td>product</td>
            <td>ProductType</td>
            <td>Indicate the product type</td>
            <td>M</td>
            <td>BROWSING</td>
        </tr>
        <tr>
            <td>quotationId</td>
            <td>String</td>
            <td>Indicate the order quotation, if pass in will retrieve the existing order, else generate new order</td>
            <td>O</td>
            <td>20210213ab6c90fb833a4831a1f0040eb2fdbce3</td>
        </tr>
    </tbody>
  </table>
  
  ```$xslt
{
    "action": "ADD",
    "quantity": "3000",
    "quotationId": "20210213ab6c90fb833a4831a1f0040eb2fdbce3",
    "product": "BROWSING"
}
```
  
**Response** 

  <table>
    <thead>
      <tr>
        <th>Key</th>
        <th>Data Type</th>
        <th>Description</th>
        <th>Required</th>
        <th>Sample</th>
      </tr>
    </thead>
    <tbody>
        <tr>
            <td>quotationId</td>
            <td>String</td>
            <td>Order quotation id</td>
            <td>M</td>
            <td>20210213ab6c90fb833a4831a1f0040eb2fdbce3</td>
        </tr>
        <tr>
            <td>orderAmount</td>
            <td>String</td>
            <td>The order total amount</td>
            <td>M</td>
            <td>3000</td>
        </tr>
        <tr>
            <td>statusCode</td>
            <td>String</td>
            <td>Response status code</td>
            <td>M</td>
            <td>00000</td>
        </tr>
        <tr>
            <td>statusMsg</td>
            <td>String</td>
            <td>Response status message</td>
            <td>M</td>
            <td>OK</td>
        </tr>
    </tbody>
  </table>
  
```$xslt
{
    "extendInfo": null,
    "statusCode": "0000",
    "statusMsg": "OK",
    "quotationId": "20210213ab6c90fb833a4831a1f0040eb2fdbce3",
    "orderAmount": "20000"
}
```
  
  
 ###2. /1.0/payment/order (JSON)
 
 This API is use for make payment
 
 **Request**
  <table>
     <thead>
       <tr>
         <th>Key</th>
         <th>Data Type</th>
         <th>Description</th>
         <th>Required</th>
         <th>Sample</th>
       </tr>
     </thead>
     <tbody>
         <tr>
             <td>payAmount</td>
             <td>String</td>
             <td>The payment amount</td>
             <td>M</td>
             <td>1</td>
         </tr>
         <tr>
             <td>quotationId</td>
             <td>String</td>
             <td>Indicate the order quotation</td>
             <td>M</td>
             <td>20210213ab6c90fb833a4831a1f0040eb2fdbce3</td>
         </tr>
     </tbody>
   </table>
   
  ```$xslt
{
    "payAmount": "30090",
    "quotationId": "20210213ab6c90fb833a4831a1f0040eb2fdbce3"
}
```
   
  **Response**
<table>
    <thead>
      <tr>
        <th>Key</th>
        <th>Data Type</th>
        <th>Description</th>
        <th>Required</th>
        <th>Sample</th>
      </tr>
    </thead>
    <tbody>
        <tr>
            <td>changeAmount</td>
            <td>String</td>
            <td>The change amount</td>
            <td>M</td>
            <td>1000</td>
        </tr>
        <tr>
            <td>denomDTOList</td>
            <td>List DenomDTO</td>
            <td>The return money denom list</td>
            <td>M</td>
            <td></td>
        </tr>
        <tr>
            <td>statusCode</td>
            <td>String</td>
            <td>Response status code</td>
            <td>M</td>
            <td>00000</td>
        </tr>
        <tr>
            <td>statusMsg</td>
            <td>String</td>
            <td>Response status message</td>
            <td>M</td>
            <td>OK</td>
        </tr>
    </tbody>
  </table>
  
  ```$xslt
{
    "extendInfo": null,
    "statusCode": "0000",
    "statusMsg": "OK",
    "changeAmount": "10090",
    "denomDTOList": [
        {
            "denom": "FIVE_THOUSAND",
            "quantity": 2
        },
        {
            "denom": "ONE_THOUSAND",
            "quantity": 0
        },
        {
            "denom": "FIVE_HUNDRED",
            "quantity": 0
        },
        {
            "denom": "ONE_HUNDRED",
            "quantity": 0
        },
        {
            "denom": "TEN",
            "quantity": 9
        },
        {
            "denom": "ONE",
            "quantity": 0
        }
    ]
}
```
  
 ###3. Data model
 <table>
     <thead>
       <tr>
         <th>ActionEnum</th>
       </tr>
     </thead>
     <tbody>
         <tr>
             <td>ADD</td>
         </tr>
         <tr>
             <td>REMOVE</td>
         </tr>         
     </tbody>
   </table>
 <table>
     <thead>
       <tr>
         <th>ProductType</th>
       </tr>
     </thead>
     <tbody>
         <tr>
             <td>SCAN</td>
         </tr>
         <tr>
             <td>PRINT_BLACK_WHITE</td>
         </tr>
         <tr>
             <td>PRINT_COLOR</td>
         </tr>
         <tr>
             <td>DRINK</td>
         </tr>
         <tr>
             <td>BROWSING</td>
         </tr>
         <tr>
             <td>TYPING</td>
         </tr>
         <tr>
             <td>GAMING</td>
         </tr>        
     </tbody>
   </table>
  <table>
      <thead>
        <tr>
          <th>DenomDTO</th>
        </tr>
      </thead>
      <tbody>
          <tr>
              <td>ONE</td>
          </tr>
          <tr>
              <td>TEN</td>
          </tr>
          <tr>
              <td>ONE_HUNDRED</td>
          </tr>
          <tr>
              <td>FIVE_HUNDRED</td>
          </tr>
          <tr>
              <td>ONE_THOUSAND</td>
          </tr>
          <tr>
              <td>FIVE_THOUSAND</td>
          </tr>       
      </tbody>
    </table>
    
