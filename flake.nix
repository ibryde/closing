{
  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
  };

  outputs = { self, nixpkgs }: 
  let
    system = "x86_64-linux"; 
    pkgs = import nixpkgs { 
      inherit system; 
      config.allowUnfree = true;
    };
  in
  {
    # Your environment definition here

    devShells.${system}.default = pkgs.mkShell {
      buildInputs = with pkgs;
      [
        # Other dependencies
        maven
        kotlin
        caddy
        # For HTTPS certification
        nss
      ];
    };
  };
}
