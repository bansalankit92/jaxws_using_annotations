
/**
 * LibServiceServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */

    package com.psl.service;

    /**
     *  LibServiceServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class LibServiceServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public LibServiceServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public LibServiceServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for addBook method
            * override this method for handling normal response from addBook operation
            */
           public void receiveResultaddBook(
                    com.psl.service.LibServiceServiceStub.AddBookResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addBook operation
           */
            public void receiveErroraddBook(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBookNamebyID method
            * override this method for handling normal response from getBookNamebyID operation
            */
           public void receiveResultgetBookNamebyID(
                    com.psl.service.LibServiceServiceStub.GetBookNamebyIDResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBookNamebyID operation
           */
            public void receiveErrorgetBookNamebyID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for bookList method
            * override this method for handling normal response from bookList operation
            */
           public void receiveResultbookList(
                    com.psl.service.LibServiceServiceStub.BookListResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from bookList operation
           */
            public void receiveErrorbookList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBookbyID method
            * override this method for handling normal response from getBookbyID operation
            */
           public void receiveResultgetBookbyID(
                    com.psl.service.LibServiceServiceStub.GetBookbyIDResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBookbyID operation
           */
            public void receiveErrorgetBookbyID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBookbyNameOrID method
            * override this method for handling normal response from getBookbyNameOrID operation
            */
           public void receiveResultgetBookbyNameOrID(
                    com.psl.service.LibServiceServiceStub.GetBookbyNameOrIDResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBookbyNameOrID operation
           */
            public void receiveErrorgetBookbyNameOrID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBookbyName method
            * override this method for handling normal response from getBookbyName operation
            */
           public void receiveResultgetBookbyName(
                    com.psl.service.LibServiceServiceStub.GetBookbyNameResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBookbyName operation
           */
            public void receiveErrorgetBookbyName(java.lang.Exception e) {
            }
                


    }
    