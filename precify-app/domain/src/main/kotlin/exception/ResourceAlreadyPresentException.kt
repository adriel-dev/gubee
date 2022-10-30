package exception

class ResourceAlreadyPresentException : RuntimeException {

    constructor()
    constructor(message: String) : super(message)

}