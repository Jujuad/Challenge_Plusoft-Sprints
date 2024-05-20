package br.com.fiap.challengePlusoft.controller;

@RestController
@RequestMapping("/trafegos")
@RequiredArgsConstructor
public class TrafegoController {

    private final TrafegoService trafegoService;

    @GetMapping
    public ResponseEntity<List<Trafego>> listarTrafegos() {
        List<Trafego> trafegos = trafegoService.listarTrafegos();
        return ResponseEntity.ok(trafegos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trafego> buscarTrafegoPorId(@PathVariable Long id) {
        Trafego trafego = trafegoService.buscarTrafegoPorId(id);
        return ResponseEntity.ok(trafego);
    }

    @PostMapping
    public ResponseEntity<?> criarTrafego(@Valid @RequestBody TrafegoDTO trafegoDTO, UriComponentsBuilder uriBuilder) {
        Trafego trafego = trafegoService.criarTrafego(trafegoDTO);
        UriComponents uriComponents = uriBuilder.path("/trafegos/{id}").buildAndExpand(trafego.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(trafego);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trafego> atualizarTrafego(@PathVariable Long id, @Valid @RequestBody TrafegoDTO trafegoDTO) {
        Trafego trafegoAtualizado = trafegoService.atualizarTrafego(id, trafegoDTO);
        return ResponseEntity.ok(trafegoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTrafego(@PathVariable Long id) {
        trafegoService.deletarTrafego(id);
        return ResponseEntity.noContent().build();
    }
}

