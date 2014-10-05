public enum EnumTipoSolicitacao {
    
    A_SERVICO {

        @Override
        protected Status atrbuirStatus() {
            return new AguardandoChefia();
        }
    },
    ATESTADO {

        @Override
        protected Status atrbuirStatus() {
            return new AguardandoRH();
        }
    },
    LICENCA {

        @Override
        protected Status atrbuirStatus() {
            return new AguardandoChefia();
        }
    },
    PROBLEMA_PONTO_ELETRONICO {

        @Override
        protected Status atrbuirStatus() {
            return new AguardandoRH();
        }
    },
    OUTROS {

        @Override
        protected Status atrbuirStatus() {
            return new AguardandoChefia();
        }
    };
    
    protected abstract Status atrbuirStatus();
}