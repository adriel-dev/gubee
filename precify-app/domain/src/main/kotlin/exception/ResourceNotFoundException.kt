package exception

class ResourceNotFoundException : RuntimeException {

    constructor()
    constructor(message: String) : super(message)

}