<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Cadastro de Pedidos</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
        />
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"
        ></script>
    </head>
    <body style="background-color: #072227">
        <div class="container">
            <div class="card container mt-5" style="background-color: #35858b">
                <div class="card-body">
                    <h3 class="card-title">Cadastro de Pedidos</h3>
                    <h6
                        class="card-subtitle mb-2 text-muted mt-3"
                        style="color: black !important"
                    >
                        Preencha os campos abaixo
                    </h6>

                    <div
                        class="card container"
                        style="background-color: #4fbdba"
                    >
                        <form
                            action="CadastroPedido"
                            method="post"
                            class="mt-5 mb-2"
                        >
                            <div
                                class="d-flex justify-content-between mt-3 flex-wrap"
                            >
                                <div
                                    class="col-md-12 d-flex justify-content-between mt-3"
                                >
                                    <input
                                        type="text"
                                        name="codigoPedido"
                                        id="codigoPedido"
                                        placeholder="C�digo do Pedido"
                                    />
                                    <input
                                        type="text"
                                        name="cliente"
                                        id="cliente"
                                        placeholder="Cliente"
                                    />
                                </div>

                                <div
                                    class="col-md-12 d-flex justify-content-between mt-3"
                                >
                                    <input
                                        type="text"
                                        name="vendedor"
                                        id="vendedor"
                                        placeholder="Vendedor"
                                    />
                                    <input
                                        type="text"
                                        name="produto"
                                        id="produto"
                                        placeholder="Produto"
                                    />
                                </div>
                            </div>

                            <div class="d-flex justify-content-end mt-3">
                                <a class="me-5" href="ListaPedido.jsp"
                                    >Pesquisar</a
                                >
                                <button
                                    type="button"
                                    class="btn btn-dark"
                                    type="submit"
                                >
                                    Enviar
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
